.data
message: .asciiz "Enter your name \n"
message1: .asciiz "my  name is \n"
memspace: .space 25
.text

li $v0,4
la $a0,message
syscall

li $v0,8
la $a0,memspace
li $a1,25
syscall

li $v0,4
la $a0,message1
syscall

li $v0,4
la $a0,memspace
syscall
