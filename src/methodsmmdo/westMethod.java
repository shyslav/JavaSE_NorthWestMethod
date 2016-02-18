package methodsmmdo;

/**
 *
 * @author shyshkin_vlad
 * @version 1.01
 */
public class westMethod {
    /**
     * @param m - количество строк
     * @param n - количество столбцов
     * @param costArray - входящий массив транспортной задачи
     * @param answer - массив ответа
     * @param z - целевая функция
     */
    public void Method() {
//        int[][] costArray = {{1, 2, 3, 0 , 5},
//                       {1, 4, 2, 0 , 10},
//                       {3, 3, 3, 6, 0}};
                int[][] costArray = {{5, 8, 4, 3 , 8},
                                     {5, 2, 6, 5 , 4},
                                     {8, 6, 5, 4, 7},
                                     {6, 4, 7, 5, 7},
                                     {7, 9, 5, 5, 0}};        
        int m = costArray.length;
        int n = costArray[0].length;
        System.out.println("n="+n+" m="+ m);
        //Вывод входящего массива
        functions.output(costArray);
        //Проверка условия баланса
        if(!functions.sum(costArray))
        {
            System.out.println("Условие баланса не выполнено");
        }
        else
        {
            System.out.println("Условие баланса выполнено, продолжаем решение");
        }
        int [][] answer = new int [m-1][n-1];    
        int bIter = 0;
        for(int i = 0; i<m-1;i++)
        {
            for( ; bIter<n-1;bIter++)
            {
                // найти минимум между производством и потребностью
                int min = functions.min(costArray[i][n-1],costArray[m-1][bIter]);
                // добавить это значение в массив
                answer[i][bIter]=min;
                if(min == costArray[i][n-1])
                {                
                    //перейти на следующую строку
                    costArray[m-1][bIter]-=costArray[i][n-1];
                    costArray[i][n-1]=0;
                    break;
                }
                else
                {
                    //перейти на следующий столбец
                    costArray[i][n-1]=costArray[i][n-1]-costArray[m-1][bIter];
                    costArray[m-1][bIter]=0;
                }
            }
        }
         System.out.println("Ответ:");
         functions.output(answer);
         System.out.println("Целевая функция:");
         functions.z(costArray, answer);
         if(Math.abs(m+n)-3==functions.basic(answer))
         {
             System.out.println("Количество базисных переменных совпало");
         }
    }
}
