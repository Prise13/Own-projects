#include <iostream>
#include <string>
using namespace std;


int main() {
	string password;
	while (true) {
		cout << "Enter your password: ";
		cin >> password;
		if (password.length() > 4) {
			cout << "Wrong length!";
		}
		else {
			break;
		}
	}
	string symbols = "abcdefghijklmnopqrstuvwxyz";
	bool check = false;
	for (int i = 0; i < symbols.length(); i++) {
		char symbol_one = symbols[i];
		for (int j = 0; j < symbols.length(); j++) {
			char symbol_two = symbols[j];
			for (int k = 0; k < symbols.length(); k++) {
				char symbol_three = symbols[k];
				if (check == true) 
					break;
				for (int l = 0; l < symbols.length(); l++) {
					char symbol_four = symbols[l];
					string brute{ symbol_one, symbol_two, symbol_three, symbol_four };
					cout << "Bruting in progress: " << brute << endl;
					if (brute == password) {
						cout << "Success! The password is: " << brute;
						check = true;
						break;
					}
				}
			}
		}
	}
}