package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CounterTest 
{
    
    BlankCounter blankCounter = new BlankCounter();
    CodeCounter codeCounter = new CodeCounter();
    CommentCounter commentCounter = new CommentCounter();
    

    @Before
    public void init_Counter(){
        ArrayList<String> pathlist = new ArrayList<>();
        pathlist.add("testsample");
        blankCounter.set_path(pathlist);
        codeCounter.set_path(pathlist);
        commentCounter.set_path(pathlist);   
    }


    //test blankCounter
    @Test
    public void blankCounterTest(){
        assertEquals(true, blankCounter.isBlank(""));
        assertEquals(true, blankCounter.isBlank(" "));
        assertEquals(true, blankCounter.isBlank("                  "));

        blankCounter.playCount();
        assertEquals(2, blankCounter.get_num());
    }

    //test codeCounter
    @Test
    public void codeCounterTest(){
        assertEquals(true, codeCounter.isCode("code //"));
        assertEquals(true, codeCounter.isCode("code /*"));
        

        assertEquals(false, codeCounter.isCode(""));
        assertEquals(false, codeCounter.isCode(" "));
        assertEquals(false, codeCounter.isCode(" //"));
        assertEquals(false, codeCounter.isCode("//"));
        assertEquals(false, codeCounter.isCode("//   comment"));
        assertEquals(false, codeCounter.isCode("/*"));
        assertEquals(false, codeCounter.isCode(" /*"));
        assertEquals(false, codeCounter.isCode("/*    comment"));
        assertEquals(false, codeCounter.isCode("/*    */"));
        
        codeCounter.playCount();
        assertEquals(3, codeCounter.get_num());
    }


    //test commentCounter
    @Test
    public void commentCounterTest(){
        assertEquals(true, commentCounter.isComment("//"));
        assertEquals(true, commentCounter.isComment(" //"));
        assertEquals(true, commentCounter.isComment("//  comment"));
        
        assertEquals(true, commentCounter.isComment("/*"));
        assertEquals(true, commentCounter.isComment(" /*"));
        assertEquals(true, commentCounter.isComment("/*   comment"));
        assertEquals(true, commentCounter.isComment("/*    */"));
        //assertEquals(true, commentCounter.isComment("code /*    */"));

        commentCounter.playCount();
        assertEquals(3, commentCounter.get_num());
    }
    

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
