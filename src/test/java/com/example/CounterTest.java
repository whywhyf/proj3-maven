package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class CounterTest 
{
    
    BlankCounter blankCounter = new BlankCounter();
    CodeCounter codeCounter = new CodeCounter();
    CommentCounter commentCounter = new CommentCounter();
    

    @Before
    public void init_Counter(){
        
    }


    //test blankCounter
    @Test
    public void blankCounterTest(){
        assertEquals(true, blankCounter.isBlank(""));
        assertEquals(true, blankCounter.isBlank(" "));
        assertEquals(true, blankCounter.isBlank("                  "));
    }

    //test codeCounter
    @Test
    public void codeCounterTest(){
        assertEquals(true, codeCounter.isCode("code //"));
        assertEquals(true, codeCounter.isCode("code /*"));

        assertEquals(false, codeCounter.isCode(" //"));
        assertEquals(false, codeCounter.isCode("//"));
        assertEquals(false, codeCounter.isCode("//   comment"));
        assertEquals(false, codeCounter.isCode("/*"));
        assertEquals(false, codeCounter.isCode(" /*"));
        assertEquals(false, codeCounter.isCode("/*    comment"));
        assertEquals(false, codeCounter.isCode("/*    */"));
    }


    //test commentCounter
    @Test
    public void commentCounterTest(){
        assertEquals(true, commentCounter.isComment("//"));
        assertEquals(true, commentCounter.isComment(" //"));
        assertEquals(true, commentCounter.isComment("//  comment"));
        assertEquals(true, commentCounter.isComment("code //"));
        assertEquals(true, commentCounter.isComment("/*"));
        assertEquals(true, commentCounter.isComment(" /*"));
        assertEquals(true, commentCounter.isComment("/*   comment"));
        assertEquals(true, commentCounter.isComment("/*    */"));
        assertEquals(true, commentCounter.isComment("code /*    */"));
    }
    

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
 