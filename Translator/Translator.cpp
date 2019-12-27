#include <iostream>
#include <string>
#include <map>
#include <fstream>
using namespace std;




int main() {
	setlocale(LC_ALL, "Russian");
	map<string, string> m;
	fstream file;
	cout << "Welcome to the dictionary translator! Enter name of your dictionary file: ";
	string dict_name;
	cin >> dict_name;
	file.open(dict_name);
	if (file.is_open()) {
		while (!file.eof()) {
			string english;
			string russian;
			getline(file, english, ':');
			getline(file, russian, ':');
			m[english] = russian;
		}
		while (true) {
			string word;
			cout << "Enter english word: ";
			cin >> word;
			auto it = m.find(word);
			if (it != m.end()) {
				cout << "Here is your translation: " << it->second << endl;
			}
			else {
				cout << "Couldn't find this word in your dictionary file, check it out and try again" << endl;
			}
		}
	}
	else {
		cout << "File ins't opened";
	}
}
