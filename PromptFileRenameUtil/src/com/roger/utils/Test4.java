package com.roger.utils;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test4 {
	public static void main(String[] args){
		
		 String input="PS&lt;http://c4t26225.itcs.hpecorp.net:8080/prompts/DTMFMenu_TEST/en_Opt1.wav&gt;;PS&lt;http://c4t26225.itcs.hpecorp.net:8080/prompts/DTMFMenu_TEST/en_Opt2.wav&gt;;PS&lt;http://c4t26225.itcs.hpecorp.net:8080/prompts/DTMFMenu_TEST/en_Opt3.wav&gt;;PS&lt;http://c4t26225.itcs.hpecorp.net:8080/prompts/DTMFMenu_TEST/en_Opt4.wav&gt;;";
		 ArrayList promptList = stringToPrompt (input);
	}
	
	public static ArrayList stringToPrompt( String paramString)
	  {
	    System.out.println("PromptHelper.stringToPrompt: Prompt String:[" + paramString + "].");
	    ArrayList localArrayList = new ArrayList();
	    String str1 = null;
	    String str2 = null;
	    while (paramString.length() > 0)
	    {
		 System.out.println( "#1 Enter while: paramStringlen="+paramString.length());

	      int i = paramString.indexOf("&gt;;");
	      System.out.println( "#2 Enter while: i="+i);
	      System.out.println( "PromptHelper.stringToPrompt: index:[" + i + "].");
	      String str3;
	      StringTokenizer localStringTokenizer;
	      PromptType localPromptType;
	      if (i > -1)
	      {
		    System.out.println( "#3 Enter IF i="+i);
	        str3 = paramString.substring(0, i);
		    System.out.println( "#4 Enter IF str3="+str3);
	        paramString = paramString.substring(i + 5);
		    System.out.println( "#5 Enter IF paramString="+paramString);
	        localStringTokenizer = new StringTokenizer(str3, "&lt;");
		    System.out.println( "#6 Enter IF str3="+str3);
		  System.out.println( "#7 Enter IF localStringTokenizer=####");
		  String[] Str1Str2=str3.split("&lt;");
		  System.out.println( "#8 Exit from  IF localArrayList="+Str1Str2.length);
		  if(Str1Str2.length>1){ 
          localPromptType = new PromptType();
          str1 = Str1Str2[0];
          System.out.println("PromptHelper.stringToPrompt: promptType str1:[" + str1 + "].");
          localPromptType.setType(str1);
          str2 = Str1Str2[1];
          System.out.println( "PromptHelper.stringToPrompt: promptValue str2:[" + str2 + "].");
          localPromptType.setValue(str2);
          localArrayList.add(localPromptType);
		  }
		  System.out.println( "#8 Exit from  IF localArrayList="+localArrayList.size());
	      }
	      else
	      {
			  System.out.println( "#9 Break while");
	    	  break;
	      }
	    }
	    return localArrayList;
	  }
	
	
	
	public static ArrayList stringToPromptNew( String paramString)
	  {
	    System.out.println("PromptHelper.stringToPrompt: Prompt String:[" + paramString + "].");
	    ArrayList localArrayList = new ArrayList();
	    String str1 = null;
	    String str2 = null;
	    while (paramString.length() > 0)
	    {
		      System.out.println( "#1 Enter while: paramStringlen="+paramString.length());

	      int i = paramString.indexOf("&gt;;");
	      System.out.println( "#2 Enter while: i="+i);

	      System.out.println( "PromptHelper.stringToPrompt: index:[" + i + "].");
	      String str3;

	      StringTokenizer localStringTokenizer;
	      PromptType localPromptType;
	      if (i > -1)
	      {
		      System.out.println( "#3 Enter IF i="+i);

	        str3 = paramString.substring(0, i);
	        
		      System.out.println( "#4 Enter IF str3="+str3);

	        paramString = paramString.substring(i + 2);
		      System.out.println( "#5 Enter IF paramString="+paramString);

	        localStringTokenizer = new StringTokenizer(str3, "PS&lt;");
		      System.out.println( "#6 Enter IF str3="+str3);

	      // while (localStringTokenizer.hasMoreTokens())
	       // {
			      System.out.println( "#7 Enter IF localStringTokenizer=####");

	          localPromptType = new PromptType();
	          str1 = localStringTokenizer.nextToken();
	          System.out.println("PromptHelper.stringToPrompt: promptType:[" + str1 + "].");
	          localPromptType.setType(str1);
	          str2 = localStringTokenizer.nextToken();
	          System.out.println( "PromptHelper.stringToPrompt: promptValue:[" + str2 + "].");
	          localPromptType.setValue(str2);
	          localArrayList.add(localPromptType);
	        }
	     // }
	      else
	      {
	        str3 = paramString.substring(0, i);
	        System.out.println( "PromptHelper.stringToPrompt: lastParsedString:[" + str3 + "].");
	        localStringTokenizer = new StringTokenizer(str3, "<");
	        while (localStringTokenizer.hasMoreTokens())
	        {
	          localPromptType = new PromptType();
	          str1 = localStringTokenizer.nextToken();
	          System.out.println( "PromptHelper.stringToPrompt: promptType:[" + str1 + "].");
	          localPromptType.setType(str1);
	          str2 = localStringTokenizer.nextToken();
	          System.out.println( "PromptHelper.stringToPrompt: promptValue:[" + str2 + "].");
	          localPromptType.setValue(str2);
	        }
	        paramString = "";
	      }
	    }
	    return localArrayList;
	  }
/*
	  public String promptToString(TraceReport paramTraceReport, SCESession paramSCESession, String paramString, Prompt paramPrompt)
	  {
	    StringBuffer localStringBuffer = new StringBuffer();
	    ArrayList localArrayList = paramPrompt.getElements(1);
	    int i = localArrayList.size();
	    PromptElement localPromptElement = null;
	    int j = 0;
	    for (int k = 0; k < i; k++)
	    {
	      localPromptElement = (PromptElement)localArrayList.get(k);
	      paramTraceReport.trace(1, "PromptHelper.promptToString: Prompt Element [" + k + "] = [" + localPromptElement + "].");
	      j = localPromptElement.getType();
	      String str3;
	      switch (j)
	      {
	      case 9: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is phrase set.");
	        Phrase localPhrase1 = localPromptElement.getPhrase();
	        String str1 = localPhrase1.getURL();
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Phrase URL = [" + str1 + "].");
	        localStringBuffer.append("PS");
	        localStringBuffer.append("&lt;");
	        localStringBuffer.append(str1);
	        localStringBuffer.append("&gt;;");
	        break;
	      case 2: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is phrase.");
	        Phrase localPhrase2 = localPromptElement.getPhrase();
	        String str2 = localPhrase2.getURL();
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Phrase URL = [" + str2 + "].");
	        localStringBuffer.append("P");
	        localStringBuffer.append("&lt;");
	        localStringBuffer.append(str2);
	        localStringBuffer.append("&gt;;");
	        break;
	      case 4: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is variable audio.");
	        Phrase[] arrayOfPhrase = null;
	        arrayOfPhrase = localPromptElement.getFormattedVariableAudio();
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Phrase Array [" + arrayOfPhrase + "]");
	        if (arrayOfPhrase != null)
	        {
	          str3 = getStandardPhrasePath(paramTraceReport, paramSCESession, paramString);
	          for (int m = 0; m < arrayOfPhrase.length; m++) {
	            if (arrayOfPhrase[m] != null)
	            {
	              String str5 = arrayOfPhrase[m].getFileName();
	              paramTraceReport.trace(1, "PromptHelper.promptToString: Var Audio Phrase [" + m + "] Filename = [" + str5 + "].");
	              String str6 = null;
	              if ((str5 != null) && (str5.indexOf(":") == -1))
	              {
	                str6 = str3 + str5;
	                paramTraceReport.trace(1, "PromptHelper.promptToString: Var Audio Phrase [" + m + "] Added base path.  New Filename = [" + str6 + "].");
	              }
	              localStringBuffer.append("VA");
	              localStringBuffer.append("&lt;");
	              localStringBuffer.append(str6);
	              localStringBuffer.append("&gt;;");
	            }
	            else
	            {
	              paramTraceReport.trace(3, "PromptHelper.promptToString: Var Audio Phrase [" + m + "] at element [" + k + "] is null.");
	            }
	          }
	        }
	        else
	        {
	          paramTraceReport.trace(3, "PromptHelper.promptToString: Var Audio Phrase Array was null.");
	        }
	        break;
	      case 1: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is text.");
	        str3 = localPromptElement.getText();
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Text = [" + str3 + "].");
	        if (str3 != null)
	        {
	          str3 = str3.replace("&lt;", "&lt;");
	          str3 = str3.replace("&gt;;", "&gt;");
	        }
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Text Type: Text after replacement = [" + str3 + "].");
	        localStringBuffer.append("T");
	        localStringBuffer.append("&lt;");
	        localStringBuffer.append(str3);
	        localStringBuffer.append("&gt;;");
	        break;
	      case 3: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is variable text.");
	        String str4 = localPromptElement.getFormattedVariableText();
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Formatted Text = [" + str4 + "].");
	        if (str4 != null)
	        {
	          str3 = str4.replace("&lt;", "&lt;");
	          str3 = str4.replace("&gt;;", "&gt;");
	        }
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Text Type: Text after replacement = [" + str4 + "].");
	        localStringBuffer.append("VT");
	        localStringBuffer.append("&lt;");
	        localStringBuffer.append(str4);
	        localStringBuffer.append("&gt;;");
	        break;
	      case 5: 
	      case 6: 
	      case 7: 
	      case 8: 
	      default: 
	        paramTraceReport.trace(1, "PromptHelper.promptToString: Type is unknown [" + j + "].");
	      }
	    }
	    paramTraceReport.trace(1, "PromptHelper.promptToString: Returning promptBuffer [" + localStringBuffer + "].");
	    return localStringBuffer.toString();
	  }
	  */
}
