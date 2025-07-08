.data 
myarray: .space 16
.text 
li $t0,1
li $t1,2
li $t2,3
li $t3,4

li $t4,0
sw $t0,myarray($t4)
addi $s1,$t4,4
sw $t1,myarray($s1)
addi $s2,$s1,4
sw $t2,myarray($s2)
addi $s3,$s2,4
sw $t3,myarray($s3)

lw $t5,myarray($s2)
li $v0,1
addi $a0,$t5,0
syscall
