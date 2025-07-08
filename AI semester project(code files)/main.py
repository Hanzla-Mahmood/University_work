import cv2

# Threshold for detection confidence
thres = 0.45

# Open the webcam (0 is the default camera)
cap = cv2.VideoCapture(0)

# Check if the webcam is opened correctly
if not cap.isOpened():
    raise Exception("Error: Could not access the camera.")

print("Camera accessed successfully.")

# Set webcam resolution
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 640)  # Width
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)  # Height

# Load class names (Ensure 'coco.names' exists in the working directory)
classFile = 'coco.names'
try:
    with open(classFile, 'rt') as f:
        classNames = f.read().rstrip('\n').split('\n')
except FileNotFoundError:
    raise Exception(f"Error: '{classFile}' not found. Ensure it exists in the working directory.")

# Load model configuration and weights
configPath = 'ssd_mobilenet_v3_large_coco_2020_01_14.pbtxt'
weightPath = 'frozen_inference_graph.pb'

try:
    net = cv2.dnn_DetectionModel(weightPath, configPath)
except cv2.error as e:
    raise Exception(f"Error loading model: {str(e)}")

# Configure the model
net.setInputSize(320, 320)
net.setInputScale(1.0 / 127.5)
net.setInputMean((127.5, 127.5, 127.5))
net.setInputSwapRB(True)

print("Model configured successfully!")

while True:
    # Capture frame from webcam
    success, img = cap.read()

    if not success:
        print("Error: Failed to capture image. Exiting...")
        break

    # Perform object detection
    classIds, confs, bbox = net.detect(img, confThreshold=thres)

    # If objects are detected, draw bounding boxes and labels
    if len(classIds) != 0:
        for classId, confidence, box in zip(classIds.flatten(), confs.flatten(), bbox):
            # Draw the bounding box
            cv2.rectangle(img, box, color=(0, 255, 0), thickness=2)

            # Prepare label text
            label = f"{classNames[classId - 1].upper()} {confidence * 100:.2f}%"

            # Position the label text
            text_position = (box[0], box[1] - 10 if box[1] > 20 else box[1] + 20)

            # Draw label text
            cv2.putText(img, label, text_position, cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)

    # Displa/y the image
    cv2.imshow("Object Detection", img)

    # Exit on pressing 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release the webcam and close all windows
cap.release()
cv2.destroyAllWindows()
