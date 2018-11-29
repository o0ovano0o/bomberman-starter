package uet.oop.bomberman.Sound;

import java.io.*;
import java.net.URL;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
    public class Test
    {
        public static Clip play(String path)
        {
            Clip clip=null;
            AudioInputStream audio=null;
           try {
               URL url = Test.class.getResource(path);
               audio = AudioSystem.getAudioInputStream(url);
               clip = AudioSystem.getClip();
               clip.open(audio);

           } catch (UnsupportedAudioFileException e) {
               e.printStackTrace();
           } catch (LineUnavailableException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
            return clip;
        }
        public static Clip bom(){
            return play("/sound/Bomb.wav");
        }
        public static Clip die(){
            return play("/sound/die.wav");
        }
        public static Clip enemy(){
            return play("/sound/coin.wav");
        }
        public static Clip next(){
            return play("/sound/end.wav");
        }
        public static Clip nen(){
            return play("/sound/nen1.wav");
        }
    }

