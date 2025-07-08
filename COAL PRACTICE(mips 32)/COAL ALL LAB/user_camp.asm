.data 
message1: .asciiz "Enter the value of x\n"
message2: .asciiz "Enter the value of y\n"

.text 
main:
li $v0,4
la $a0,message1
syscall

li $v0,5
syscall
move $t0,$v0


li $v0,4
la $a0,message2
syscall

li $v0,5
syscall
move $t1,$v0


bne $t0,$t1,Else
addi $t0,$t0,2
li $v0,1
move $a0,$t0
syscall

li $v0,10
syscall

Else:
addi $t1,$t0,3
li $v0,1
move $a0,$t1
syscall


