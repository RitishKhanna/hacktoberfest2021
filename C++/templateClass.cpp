#include <iostream>
using namespace std;

template <class T>
T Large(T arr[], T n)
{
        T max = arr[0];
        for (int i = 1; i < n; i++)
        {
                if (arr[i] > max)
                        max = arr[i];
        }
        return max;
}

int main()
{
        int num;
        cout << "Enter number of elements in your array: ";
        cin >> num;
        int arrI[num];
        cout << "Enter integer array: ";
        for (int i = 0; i < num; i++)
        {
                cin >> arrI[i];
        }
        cout << "Largest element in this array is: " << Large<int>(arrI, num) << endl;
        float arrF[num];
        cout << "Enter float array: ";
        for (int i = 0; i < num; i++)
        {
                cin >> arrF[i];
        }
        cout << "Largest element in this array is: " << Large<float>(arrF, num) << endl;
        double arrD[num];
        cout << "Enter double array: ";
        for (int i = 0; i < num; i++)
        {
                cin >> arrD[i];
        }
        cout << "Largest element in this array is: " << Large<double>(arrD, num) << endl;
        return 0;
}
