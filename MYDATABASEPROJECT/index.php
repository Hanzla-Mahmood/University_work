<?php
$servername = "localhost";
$username = "root";
$password = "";
$conn = mysqli_connect($servername, $username, $password);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "Connection Successful<br>";

$email = $_POST['email'];
$name = $_POST['name'];
$rollno = $_POST['rollno'];
$father_name = $_POST['father_name'];
$department = $_POST['department'];
$gpa = $_POST['gpa'];

$sql = "USE databaselab";
mysqli_query($conn, $sql);

if ($_POST['action'] == 'CreateDB') {
    $sql = "DROP DATABASE IF EXISTS databaselab";
    mysqli_query($conn, $sql);
    $sql = "CREATE DATABASE databaselab";
    mysqli_query($conn, $sql);
    echo "Database created successfully<br>";
}

if ($_POST['action'] == 'CreateTable') {
    $sql = "DROP TABLE IF EXISTS hanzla";
    mysqli_query($conn, $sql);
    $sql = "CREATE TABLE hanzla (
                rollno INT PRIMARY KEY,
                email VARCHAR(50),
                name VARCHAR(25),
                father_name VARCHAR(50),
                department VARCHAR(50),
                gpa FLOAT
            );";
    mysqli_query($conn, $sql);
    echo "hanzla table created<br>";
}

if ($_POST['action'] == 'Insert') {
    $sql = "INSERT INTO hanzla (rollno, email, name, father_name, department, gpa) 
            VALUES ('$rollno', '$email', '$name', '$father_name', '$department', '$gpa')";
    mysqli_query($conn, $sql);
    echo "Inserted successfully<br>";
}

if ($_POST['action'] == 'Update') {
    $sql = "UPDATE hanzla SET email = '$email', name = '$name',
            father_name = '$father_name', department = '$department', gpa = '$gpa' WHERE rollno = '$rollno'";
    mysqli_query($conn, $sql);
    echo "Updated successfully<br>";
}

if ($_POST['action'] == 'Delete') {
    $sql = "DELETE FROM hanzla WHERE rollno = '$rollno'";
    mysqli_query($conn, $sql);
    echo "Deleted successfully<br>";
}

if ($_POST['action'] == 'View') {
    $sql = "SELECT rollno, email, name, father_name, department, gpa FROM hanzla WHERE rollno = '$rollno'";
    $result = mysqli_query($conn, $sql);
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<p>";
        echo "Roll No: " . $row["rollno"] . "<br>";
        echo "Name: " . $row["name"] . "<br>";
        echo "Email: " . $row["email"] . "<br>";
        echo "Father Name: " . $row["father_name"] . "<br>";
        echo "Department: " . $row["department"] . "<br>";
        echo "GPA: " . $row["gpa"] . "<br>";
        echo "</p>";
    }
}
?>