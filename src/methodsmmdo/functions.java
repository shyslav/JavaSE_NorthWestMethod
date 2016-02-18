package methodsmmdo;
/**
 *
 * @author shyshkin_vlad
 * @version 1.01
 */
public class functions {
    //Вывод двумерного массива
    public static void output(int [][] mas)
    {
        for(int i = 0; i<mas.length; i++)
        {
            for(int j = 0; j<mas[0].length;j++)
            {
                System.out.print(" "+mas[i][j]);
            }
            System.out.println();
        }
    }
    //Проверка условия баланса sum (a) = sum (b)
    public static boolean sum(int [][] mas)
    {
        int sum1 = 0;
        int sum2 = 0;
        System.out.print("\n Производство:");
        for (int i = 0 ; i<mas.length-1;i++)
        {
            System.out.print(" "+mas[i][mas[0].length-1]);
            sum1 +=mas[i][mas[0].length-1];
        }
        System.out.print("\n Необходимо:");
        for (int i = 0 ; i<mas[0].length-1;i++)
        {
            System.out.print(" "+mas[mas.length-1][i]);
            sum2 +=mas[mas.length-1][i];
        }
        System.out.println();
        System.out.println("Сумма производства = "+sum1+"\nСумма потребления = "+sum2);
        if(sum1==sum2)
        {
            return true;
        }
        return false;
    }
    /**
    * @return минимальное число
    */
    public static int min(int a , int b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    /**
     * 
     * @param cost - массив стоимости
     * @param answer - массив ответов
     * @return значение целевой функции
     */
    public static int z(int [][] cost , int [][] answer)
    {
        int z = 0;
        for(int i=0; i < cost.length-1;i++)
        {
            for(int j=0; j<cost[0].length-1;j++)
            {
             z+=cost[i][j] * answer[i][j];
            }
        }
        System.out.println(z);
        return z;
    }
    /**
     * 
     * @param answer - входящий массив ответов
     * @return вернуть количество базисных переменных
     */
    public static int basic(int [][] answer)
    {
        int tmp = 0;
        for(int i = 0; i<answer.length; i++)
        {
            for(int j = 0; j<answer[0].length;j++)
            {
                if(answer[i][j]!=0)
                    tmp++;
            }
        }
        return tmp;
    }
}
