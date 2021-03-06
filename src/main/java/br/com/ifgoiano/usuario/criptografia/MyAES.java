/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.usuario.criptografia;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 *
 * @author Root
 */
public class MyAES {
    


  
    

    public  String gerarMD5Hash(String password) {

        String retorno = "";

        if (!password.isEmpty()) {

            retorno = "falhou";

            try {
                // Create MD5 Hash
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(password.getBytes());
                byte messageDigest[] = digest.digest();

                StringBuffer MD5Hash = new StringBuffer();
                for (int i = 0; i < messageDigest.length; i++) {
                    String h = Integer.toHexString(0xFF & messageDigest[i]);
                    while (h.length() < 2)
                        h = "0" + h;
                    MD5Hash.append(h);
                }

                return MD5Hash.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return retorno;
    }

    ////////////////////////////////////////    
  public String criptografa(String mensagem, String chave) {
    if (mensagem.length() != chave.length()) 
    error("O tamanho da mensagem e da chave devem ser iguais.");
    int[] im = charArrayToInt(mensagem.toCharArray());
    int[] ik = charArrayToInt(chave.toCharArray());
    int[] data = new int[mensagem.length()];
    
    for (int i=0;i<mensagem.length();i++) {
      data[i] = im[i] + ik[i];
    }
    
    return new String(intArrayToChar(data));
  }
  
  public String decriptografa(String mensagem, String chave) {
    if (mensagem.length() != chave.length()) 
    error("O tamanho da mensagem e da chave devem ser iguais.");
    int[] im = charArrayToInt(mensagem.toCharArray());
    int[] ik = charArrayToInt(chave.toCharArray());
    int[] data = new int[mensagem.length()];
    
    for (int i=0;i<mensagem.length();i++) {
      data[i] = im[i] - ik[i];
    }
    
    return new String(intArrayToChar(data));
  }
  
  public String genKey(int tamanho) {
    Random randomico = new Random();
    char[] key = new char[tamanho];
    for (int i=0;i<tamanho;i++) {
      key[i] = (char) randomico.nextInt(132);
      if ((int) key[i] < 97) key[i] = (char) (key[i] + 72);
      if ((int) key[i] > 122) key[i] = (char) (key[i] - 72);
    }
    
    return new String(key);
  }
  
  
  private int chartoInt(char c) {
    return (int) c;
  }
  
  private char intToChar(int i) {
    return (char) i;
  }
    private int[] charArrayToInt(char[] cc) {
    int[] ii = new int[cc.length];
    for(int i=0;i<cc.length;i++){
      ii[i] = chartoInt(cc[i]);
    }
    return ii;
  }
  
  private char[] intArrayToChar(int[] ii) {
    char[] cc = new char[ii.length];
    for(int i=0;i<ii.length;i++){
      cc[i] = intToChar(ii[i]);
    }
    return cc;
  }
  
  private void error(String msg) {
    System.out.println(msg);
    System.exit(-1);
  }
}