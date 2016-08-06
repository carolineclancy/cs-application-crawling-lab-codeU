package com.flatironschool.javacs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import org.jsoup.select.Elements;



// Takes a URL for a Wikipedia page, downloads it, and parses it.
// It should traverse the resulting DOM tree to find the first valid link. We'll explain what "valid" means below.
// If the page has no links, or if the first link is a page we have already seen, the program should indicate failure and exit.
// If the link matches the URL of the Wikipedia page on philosophy, the program should indicate success and exit.
// Otherwise it should go back to Step 1.





public class WikiPhilosophy {
	
	final static WikiFetcher wf = new WikiFetcher();
	
	/**
	 * Tests a conjecture about Wikipedia and Philosophy.
	 * 
	 * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
	 * 
	 * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
        // some example code to get you started

		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);

		Element firstPara = paragraphs.get(0);
		
		Iterable<Node> iter = new WikiNodeIterable(firstPara);
		for (Node node: iter) {
			if (node instanceof TextNode) {
				System.out.print(node);
			}
        }

  //       String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
 
		// Elements paragraphs = wf.fetchWikipedia(url);
	 
	 //    // select the content text and pull out the paragraphs.
	 //    Element content = paragraphs.getElementById("mw-content-text");
	 
	 //    // TODO: avoid selecting paragraphs from sidebars and boxouts
	 //    Elements paras = content.select("p");

		// Element firstPara = paras.get(0);
		 
	 //    Iterable<Node> iter = new WikiNodeIterable(firstPara);
	 //    for (Node node: iter) {
	 //        if (node instanceof TextNode) {
	 //            System.out.print(node);
	 //        }
	 //    }


        // the following throws an exception so the test fails
        // until you update the code
        // String msg = "Complete this lab by adding your code and removing this statement.";
        // throw new UnsupportedOperationException(msg);
	}
}
