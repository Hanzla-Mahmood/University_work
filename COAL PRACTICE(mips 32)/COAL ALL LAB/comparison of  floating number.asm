.data 
message: .asciiz "its true"
message2: .asciiz "its false"
number1: .float 2.5
number2: .float 4.6
.text

main:
lwc1 $f0,number1
lwc1 $f2,number2

c.eq.s $f0,$f2
bc1t false
li $v0,4
la $a0,message2
syscall

li $v0,10
syscall
false:
li $v0,4
la $a0,message
syscall
