package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.OrderItem;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<OrderItem> order = new ArrayList<>();
		
		System.out.print("Enter source path: ");
		String sourceFileStr = sc.next();
		
		File source = new File(sourceFileStr);
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			String line = br.readLine();
			while (line != null) {
				String[] split = line.split(",", 3);
				String name = split[0];
				double price = Double.parseDouble(split[1]);
				int quantity = Integer.parseInt(split[2]);
				OrderItem item = new OrderItem(name, price, quantity);
				order.add(item);
				line = br.readLine();
			}
		} catch (IOException e){
			e.getMessage();
		}
		
		boolean outputFolder = new File(source.getParent() + "\\out").mkdir();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(source.getParent() + "\\out\\summary.csv"))){
			for (OrderItem item : order) {
				bw.write(item.getName() + "," + item.totalCost());
				bw.newLine();
			}
		} catch (IOException e) {
			e.getMessage();
		}
				
		sc.close();
		
	}

}
