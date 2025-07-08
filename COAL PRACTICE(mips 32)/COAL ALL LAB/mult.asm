.data 
message: .asciiz "Enter your name"
name: .space 20
.text 

li $v0,8
la $a0,name
li $a1,20
syscall

li $v0,4
la $a0,message
syscall

li $v0,4
la $a0,name
syscall