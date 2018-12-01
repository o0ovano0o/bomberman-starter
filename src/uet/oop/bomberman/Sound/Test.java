package uet.oop.bomberman.Sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;


import javax.sound.sampled.*;
    public class Test
    {
        public static AudioClip play(String path)
        {
            AudioClip clip=null;
            URL url = Test.class.getResource(path);
            clip = Applet.newAudioClip(url);

            return clip;
        }
        public static AudioClip bom(){
            return play("/sound/Bomb.wav");
        }
        public static AudioClip die(){
            return play("/sound/die.wav");
        }
        public static AudioClip enemy(){
            return play("/sound/coin.wav");
        }
        public static AudioClip next(){
            return play("/sound/end.wav");
        }
        public static AudioClip nen(){
            return play("/sound/nen1.wav");
        }
        public static AudioClip an(){
            return play("/sound/jum.wav");
        }
        public static AudioClip win(){
            return play("/sound/victory.wav");
        }
    }

