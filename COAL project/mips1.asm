.data
prompt1: .asciiz "Enter temperature scale (1 for Fahrenheit, 2 for Celsius): "
prompt2: .asciiz "Enter temperature value: "
result:  .asciiz "Converted temperature: "

.text
.globl main

main:
    # Display prompt for temperature scale
    li $v0, 4
    la $a0, prompt1
    syscall

    # Read temperature scale input
    li $v0, 5
    syscall
    move $t0, $v0   # Store temperature scale choice

    # Display prompt for temperature value
    li $v0, 4
    la $a0, prompt2
    syscall

    # Read temperature value input
    li $v0, 5
    syscall
    move $t1, $v0   # Store temperature value

    # Convert temperature based on user input
    beq $t0, 1, to_celsius   # If Fahrenheit, convert to Celsius
    beq $t0, 2, to_fahrenheit   # If Celsius, convert to Fahrenheit

to_celsius:
    # Convert Fahrenheit to Celsius: (F - 32) * 5/9
    li $t2, 32
    sub $t1, $t1, $t2   # Subtract 32 from Fahrenheit temperature
    li $t2, 5
    mult $t1, $t2   # Multiply by 5
    li $t3, 9
    div $t2, $t3   # Divide by 9
    mflo $t1   # Store result in $t1
    j display_result

to_fahrenheit:
    # Convert Celsius to Fahrenheit: (C * 9/5) + 32
    li $t2, 9
    mult $t1, $t2   # Multiply by 9
    li $t3, 5
    div $t2, $t3   # Divide by 5
    mflo $t1   # Store result in $t1
    addi $t1, $t1, 32   # Add 32 to Celsius temperature
    j display_result

display_result:
    # Display converted temperature
    li $v0, 4
    la $a0, result
    syscall

    li $v0, 1
    move $a0, $t1
    syscall

    # Exit program
    li $v0, 10
    syscall