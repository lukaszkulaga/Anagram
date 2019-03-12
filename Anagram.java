package Anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Anagram
{

	public static void main(String[] args) throws Exception
	{

		Anagram a = new Anagram();

		List<String> lista = new ArrayList<String>();
		List<String> listaAnagramow = new ArrayList<>();

		lista = a.wczytajPlik();

		if (lista.size() == 0)
		{
			System.out.println(" nie wczytano zadnych slow ");
		} else
		{
			System.out.println(String.format(" Wczytano %,d unikalnych slow. ", lista.size()));

			System.out.println(String.format(" znaleziono %,d anagramow ", listaAnagramow.size()));

			for (String s : listaAnagramow)
			{
				System.out.println(s);
			}

		}

	}

	public List<String> wczytajPlik() throws Exception
	{

		List<String> listaSlow = new ArrayList<String>();

		Set<String> slowaSet = new HashSet<String>();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("anagram.txt"));

		try
		{
			String linia;

			while ((linia = bufferedReader.readLine()) != null)
			{
				if (!linia.equals(""))
				{
					slowaSet.add(linia);
				}
			}

			bufferedReader.close();

			listaSlow.addAll(slowaSet);

		} catch (Exception e)
		{
			System.out.println(" Blad odczytu pliku ");
		}

		return listaSlow;

	}

	public List<String> znajdzAnagramy(List<String> listaSlow)
	{

		String s = " Wyszukiwanie Anagramów ";

		long totalComp = 0;

		List<String> list = new ArrayList<String>();

		System.out.print(s);

		for (int x = 0; x < listaSlow.size(); x++)
		{
			for (int y = x + 1; y < listaSlow.size(); y++)
			{

				String string1 = listaSlow.get(x).toString();
				String string2 = listaSlow.get(y).toString();

				totalComp++;

				if (porównywanieSłow(string1, string2))
				{
					if (x % 20 == 0)
					{
						System.out.print(".");
					}

					list.add(string1 + " " + string2);

				}

			}
		}
		System.out.println(String.format("\n\nliczba wykonanych porownan %,d ", totalComp));

		return list;

	}

	ArrayList<String> listaSłów = new ArrayList<>();

	public boolean porównywanieSłow(String str1, String str2)
	{
		String pstr1 = str1.toLowerCase();
		String pstr2 = str2.toLowerCase();

		char c1[] = pstr1.toCharArray();
		char c2[] = pstr2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		String sorted1 = new String(c1);
		String sorted2 = new String(c2);

		return sorted1.equals(sorted2);

	}

}
