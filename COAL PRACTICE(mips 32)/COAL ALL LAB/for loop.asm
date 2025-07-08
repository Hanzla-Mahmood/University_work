.data
.text
 main:
li $t1, 0 
li $t0, 10 
loop:
slt $t2, $t1, $t0
beq $t2, $zero, end 
li $v0,1
move $a0,$t1
addi $t1, $t1, 1 
syscall
j loop 
li $v0,10
syscall
end:
