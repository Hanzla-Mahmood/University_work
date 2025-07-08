<?php
// login.php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $email = $_POST['txtName'];
    $password = $_POST['txtpwd'];

    // Hardcoded credentials
    $correctEmail = "hanzlaf865@gmail.com";
    $correctPassword = "595877";

    if ($email === $correctEmail && $password === $correctPassword) {
        // Successful login
        header("Location: welcome.php"); // Redirect to welcome.php or another page
        exit();
    } else {
        // Failed login
        echo "Invalid email or password.";
    }
}
?>