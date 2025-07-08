.data 
message: .asciiz "Number is less than"

.text 

addi $t0,$zero,30
addi $t1,$zero,20

slt $s0,$t0,$t1
bne $s0,$zero,message2

message2:
li $v0,4
la $a0,message
syscall