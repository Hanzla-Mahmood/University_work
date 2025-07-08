.data
message: .asciiz "Select a number  1 for add  and  2  for sub\n"
message2: .asciiz "Default"
output_sum: .asciiz "sum is\n "
output_sub: .asciiz "sub is\n "

.text
main:
   
 
    li $v0, 4
    la $a0, message
    syscall

 
    li $v0, 5
    syscall
    move $t0, $v0   

  
    li $t1, 1      
    li $t2, 2       
    li $t3, 3       


    beq $t0, $t1, case_1
    beq $t0, $t2, case_2
    
 


    j default_case

case_1:

    li $v0, 4
    la $a0, output_sum
    syscall
    li $v0, 1
    li $t4,5
    li $t5,5
    add $a0,$t4,$t5     
    syscall
    j end

case_2:

    li $v0, 4
    la $a0, output_sub
    syscall
    li $v0, 1
    li $t4,5
    li $t5,5
    sub $a0,$t4,$t5      
    syscall
    j end



default_case:

     li $v0, 4
     la $a0, message2
     syscall


end:
    li $v0, 10     
    syscall
