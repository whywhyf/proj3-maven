﻿# proj3-maven

## 10.28 19:52 解耦branch

counter现在可以单独执行

testsample下是一个只用来被测试的java文件，实际不参与程序运行

tester中以testsample文件为被计数对象进行测试

remember to read both src and test file! （done）

## main

counter for blanks (done)

counter for codes 

    " xxx  */ code"

    文件末尾的null is also a balnkline

counter for comment 

    "code //"   that's a code line
    "code /*"   that's a code line
    "xxx */ code"  that's a code line

go wrang when:

    code /*
      */

    code /*
      */ code /* */

    /* */code

## remember to read both src and test file!

## now only response for :

code:

    code

    code //....

    code /*...*/

comment:
    
    //....

    /*...
    ...
    ...
    ...*/


## use vs code counter to check the result
vs code counter并不能处理所有情况，试一下cloc

