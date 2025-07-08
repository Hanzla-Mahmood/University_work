.data 
message1: .asciiz "Its True"
message2: .asciiz "Its False"

number1: .float 10.4
number2: .float 4.6
.text 
lwc1 $f0,number1
lwc1 $f2,number2

c.eq.s $f0,$f2
b exit
li $v0,4
la $a0,message2
syscall

exit:
li $


