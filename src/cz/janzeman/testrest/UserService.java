package cz.janzeman.testrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/UserService")

public class UserService {
	/**
	 * Definice "aeiou"
	 */
	private final String aeiouString = "aeiou";

	/**
	 * 
	 * @param inputText
	 * @return reverse text s "aeiou" na UpperCase
	 */
	@GET
	@Path("/reverseText")
	@Produces(MediaType.TEXT_PLAIN)
	public String getReverseText(@QueryParam("inputText") String inputText) {
		String outputText = "";
		String tmpCharBefore="";
		try {
			for (int i = inputText.length() - 1; i >= 0; i--) {
				String tmpChar = inputText.substring(i, i+1);
				if (aeiouString.contains(tmpChar)) {
					outputText += tmpChar.toUpperCase();
				} else if (!(tmpChar.equals(" ") && tmpCharBefore.equals(" "))) {
					outputText += tmpChar;
				} 
				tmpCharBefore=tmpChar;
			}
		} catch (NullPointerException e) {
			System.err.println("Prázdný string");
		}
		return outputText;
	}
}
