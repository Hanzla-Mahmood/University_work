.data
arr: .word 1,2,3,4,5,6,7,8,9,10
msg: .asciiz "sum is"
.text

main:
li $t0,0
li $t1,0
li $t2,10 
la $t3, arr 
loop:
slt $t4, $t0, $t2 
beq $t4, $zero, end 
lw $t4, 0($t3) 
add $t1, $t1, $t4 
add $t0, $t0, 1 
add $t3, $t3, 4 
j loop
end:
addi $v0, $0, 4 
la $a0, msg
syscall
addi $v0, $0, 1 
add $a0, $t1, $0
syscall
li $v0,10
syscall
