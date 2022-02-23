package com.cbtis91.controller;

public class TestNumeroFicha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 112; i++) {
			System.out.println((i < 10 ? String.format("00%d", i): i>99? String.format("%d", i):String.format("0%d", i)));
		}

	}

}
