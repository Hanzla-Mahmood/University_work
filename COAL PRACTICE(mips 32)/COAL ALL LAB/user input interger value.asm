.data 
message1: .asciiz "Enter the roll no"
message2: .asciiz "My roll no is\n"
.text 

li $v0,4
la $a0,message1
syscall

li $v0,5
syscall

move $t0,$v0

li $v0,4
la $a0,message2
syscall

li $v0,1
move $a0,$t0
syscall