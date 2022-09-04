package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of tax payers:");
		int n = sc.nextInt();
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				
				TaxPayer taxPayer = new Individual(name, annualIncome, healthExpenditures);
				taxPayers.add(taxPayer);
			} else if (type == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				
				TaxPayer taxPayer = new Company(name, annualIncome, numberOfEmployees);
				taxPayers.add(taxPayer);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAYD:");
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
		}
		System.out.println();
		
		double totalTaxes = 0.0;
		for (TaxPayer taxPayer : taxPayers) {
			totalTaxes += taxPayer.tax();
		}
		System.out.println("TOTAL TAXES: " + String.format("%.2f", totalTaxes));
		
		sc.close();

	}

}
