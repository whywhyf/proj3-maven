package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(true, blankCounter.shouldCount(""));
        assertEquals(true, blankCounter.shouldCount(" "));
        assertEquals(true, blankCounter.shouldCount("                  "));

        blankCounter.playCount();
        assertEquals(2, blankCounter.get_num());
    }

    //test codeCounter
    @Test
    public void codeCounterTest(){
        assertEquals(true, codeCounter.shouldCount("code //"));
        assertEquals(true, codeCounter.shouldCount("code /*"));
        

        assertEquals(false, codeCounter.shouldCount(""));
        assertEquals(false, codeCounter.shouldCount(" "));
        assertEquals(false, codeCounter.shouldCount(" //"));
        assertEquals(false, codeCounter.shouldCount("//"));
        assertEquals(false, codeCounter.shouldCount("//   comment"));
        assertEquals(false, codeCounter.shouldCount("/*"));
        assertEquals(false, codeCounter.shouldCount(" /*"));
        assertEquals(false, codeCounter.shouldCount("/*    comment"));
        assertEquals(false, codeCounter.shouldCount("/*    */"));
        
        codeCounter.playCount();
        assertEquals(4, codeCounter.get_num());
    }


    //test commentCounter
    @Test
    public void commentCounterTest(){
        
        assertEquals(true, commentCounter.shouldCount("//"));
        assertEquals(true, commentCounter.shouldCount(" //"));
        assertEquals(true, commentCounter.shouldCount("//  comment"));
        assertEquals(true, commentCounter.shouldCount("/*"));
        assertEquals(true, commentCounter.shouldCount(" /*"));
        assertEquals(true, commentCounter.shouldCount("/*   comment"));
        assertEquals(true, commentCounter.shouldCount("/*    */"));
        
        assertEquals(false, commentCounter.shouldCount("code //"));
        assertEquals(false, commentCounter.shouldCount("code /*    */"));
        assertEquals(false, commentCounter.shouldCount("code /*    "));commentCounter.isBlock = false;
        
        commentCounter.playCount();
        assertEquals(9, commentCounter.get_num());
    }
    

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
