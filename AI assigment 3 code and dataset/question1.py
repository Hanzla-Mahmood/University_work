
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, classification_report
import matplotlib.pyplot as plt


df = pd.read_csv('D:\AI assigment 3/diabetes.csv')

df.fillna(df.mean(), inplace=True)


scaler = StandardScaler()
scaled_features = scaler.fit_transform(df.drop(columns=['Outcome']))

df_scaled = pd.DataFrame(scaled_features, columns=df.columns[:-1])
df_scaled['Outcome'] = df['Outcome']
X = scaled_features
y = df['Outcome']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

model = LogisticRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)
precision = precision_score(y_test, y_pred)
recall = recall_score(y_test, y_pred)
f1 = f1_score(y_test, y_pred)

print(f"Accuracy: {accuracy:.2f}")
print(f"Precision: {precision:.2f}")
print(f"Recall: {recall:.2f}")
print(f"F1-Score: {f1:.2f}")


print("\nClassification Report:")
print(classification_report(y_test, y_pred))
X_reduced = df[['Glucose', 'BMI']]
X_reduced_scaled = scaler.fit_transform(X_reduced)

X_train_red, X_test_red, y_train_red, y_test_red = train_test_split(X_reduced_scaled, y, test_size=0.2, random_state=42)

model.fit(X_train_red, y_train_red)

x_min, x_max = X_reduced_scaled[:, 0].min() - 1, X_reduced_scaled[:, 0].max() + 1
y_min, y_max = X_reduced_scaled[:, 1].min() - 1, X_reduced_scaled[:, 1].max() + 1
xx, yy = np.meshgrid(np.arange(x_min, x_max, 0.01), np.arange(y_min, y_max, 0.01))

Z = model.predict(np.c_[xx.ravel(), yy.ravel()])
Z = Z.reshape(xx.shape)

plt.contourf(xx, yy, Z, alpha=0.8, cmap='coolwarm')
plt.scatter(X_reduced_scaled[:, 0], X_reduced_scaled[:, 1], c=y, edgecolors='k', cmap='coolwarm')
plt.xlabel('Glucose')
plt.ylabel('BMI')
plt.title('Decision Boundary')
plt.show()