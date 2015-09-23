/**
 * @author Lev Zakharov
 * 11401
 * Created on 21.09.2015
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task09b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		boolean run = true;
		Pattern p = Pattern.compile("/(?<operation>add|mult)/(?<num1>\\d+)/(?<num2>\\d+)");

		while (run) {
			String request = in.nextLine();

			if (request.equals("exit")) {
				run = false;	
			}

			Matcher m = p.matcher(request);

			if (request.equals("/getdata")) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					writer.write("<p>" + page.getName().replaceFirst("\\..+", "") + "</p>");
					writer.close();
				}	catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			} else if (m.matches()) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					if (m.group("operation").equals("add")) {
						System.out.println(Integer.parseInt(m.group("num1")) + " " + Integer.parseInt(m.group("num2")));
						writer.write("<p>" + (Integer.parseInt(m.group("num1")) + Integer.parseInt(m.group("num2"))) + "</p>");
					} else {
						writer.write("<p>" + (Integer.parseInt(m.group("num1")) * Integer.parseInt(m.group("num2"))) + "</p>");
					}
					writer.close();
				}	catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			}

			if (request.equals("/baidu.com/search")) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					writer.write("<form name=\"search-baidu\" action=\"http://www.baidu.com/s\">" +
											 "<input name=\"wd\" type=\"text\">" + 
											 "<input name=\"submit\" type=\"submit\">" +
											 "</form>");
					writer.close();
				} catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			}

			if (request.equals("/bing.com/search")) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					writer.write("<form name=\"search-bing\" action=\"http://www.bing.com/search\">" +
											 "<input name=\"q\" type=\"text\">" + 
											 "<input name=\"submit\" type=\"submit\">" +
											 "</form>");
					writer.close();
				} catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			}

			if (request.equals("/yahoo.com/search")) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					writer.write("<form name=\"search-baidu\" action=\"https://search.yahoo.com/search\">" +
											 "<input name=\"p\" type=\"text\">" + 
											 "<input name=\"submit\" type=\"submit\">" +
											 "</form>");
					writer.close();
				} catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			}

			if (request.equals("/aol.com/search")) {
				try {
					File page = createPage(request);
					FileWriter writer = new FileWriter(page.getAbsoluteFile());
					writer.write("<form name=\"search-baidu\" action=\"http://search.aol.com/aol/search\">" +
											 "<input name=\"q\" type=\"text\">" + 
											 "<input name=\"submit\" type=\"submit\">" +
											 "</form>");
					writer.close();
				} catch (IOException e) {
					System.out.println("Can't create Page:(");
				}
			}
		}
	}

	private static File createPage(String request) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		Date date = new Date();
		File page = new File(dateFormat.format(date) + ".html");
		if (page.createNewFile()) {
			return page;
		} else {
			throw new IOException();
		}

	}
}