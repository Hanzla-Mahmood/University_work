.data
main:
number1: .word 5
number2: .word 10

.text
 lw $t0,number1
 lw $t1,number2
 add $t2,$t0,$t1


li $v0,1
move $a0,$t2
syscall 

li $v0,10
syscall