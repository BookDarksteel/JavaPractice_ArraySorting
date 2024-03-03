//JavaPractice_ArraySorting
//version:1.0r
//Main.java
//Book Darksteel
//完成日期：2024年2月15日

public class ArrayForSorting {
    private int array_length;
    private int[] original_array;
    private int[] current_array;

    public ArrayForSorting(int array_length,int[] array) {
        this.array_length=array_length;
        this.original_array=new int[array_length];
        this.current_array=new int[array_length];
        for(int i=0;i<array_length;++i){
            this.original_array[i]=array[i];
            this.current_array[i]=array[i];
        }
    }

    public void print_original_array(){
        System.out.println("原始数组：");
        print_array(this.array_length,this.original_array);
    }

    public void print_current_array(){
        System.out.println("当前数组：");
        print_array(this.array_length,this.current_array);
    }

    public void bubble_sort(boolean show_details){
        if(is_sorted(this.array_length,this.current_array)){
            System.out.println("提示：当前数组已按升序排列");
        }
        System.out.println("开始对当前数组进行冒泡排序");
        if(show_details){
            System.out.println("排序开始前的数组：");
            print_array(this.array_length,this.current_array);
        }
        for(int rounds_count=1;rounds_count<this.array_length;++rounds_count){
            boolean completed=true;
            for(int i=0;i<this.array_length-1;++i){
                if(this.current_array[i]>this.current_array[i+1]){
                    int temp=this.current_array[i+1];
                    this.current_array[i+1]=this.current_array[i];
                    this.current_array[i]=temp;
                    completed=false;
                }
            }
            if(show_details){
                System.out.println("第"+rounds_count+"轮排序后的数组：");
                print_array(this.array_length,this.current_array);
            }
            if(completed){
                break;
            }
        }
        System.out.println("冒泡排序完成\n");
    }

    public void insertion_sort(boolean show_details){
        if(is_sorted(this.array_length,this.current_array)){
            System.out.println("提示：当前数组已按升序排列");
        }
        System.out.println("开始对当前数组进行插入排序");
        if(show_details){
            System.out.println("排序开始前的数组：");
            print_array(this.array_length,this.current_array);
        }
        for(int rounds_count=1;rounds_count<this.array_length;++rounds_count){
            int intertion_position=rounds_count;
            int temp=this.current_array[intertion_position];
            while (intertion_position>0){
                if(this.current_array[intertion_position-1]>temp){
                    this.current_array[intertion_position]=this.current_array[intertion_position-1];
                    --intertion_position;
                }
                else{
                    break;
                }
            }
            this.current_array[intertion_position]=temp;
            if(show_details){
                System.out.println("第"+rounds_count+"轮排序后的数组：");
                print_array(this.array_length,this.current_array);
            }
        }
        System.out.println("插入排序完成\n");
    }

    public void select_sort(boolean show_details){
        if(is_sorted(this.array_length,this.current_array)){
            System.out.println("提示：当前数组已按升序排列");
        }
        System.out.println("开始对当前数组进行选择排序");
        if(show_details){
            System.out.println("排序开始前的数组：");
            print_array(this.array_length,this.current_array);
        }
        for(int sorted_length=0;sorted_length<this.array_length;++sorted_length){
            int unsorted_min_i=sorted_length;
            for(int i=sorted_length+1;i<this.array_length;++i){
                if(this.current_array[unsorted_min_i]>this.current_array[i]){
                    unsorted_min_i=i;
                }
            }
            int temp=this.current_array[sorted_length];
            this.current_array[sorted_length]=this.current_array[unsorted_min_i];
            this.current_array[unsorted_min_i]=temp;
            if(show_details){
                System.out.println("第"+(sorted_length+1)+"轮排序后的数组：");
                print_array(this.array_length,this.current_array);
            }
        }
        System.out.println("选择排序完成\n");
    }

    public void reverse(boolean show_details){
        System.out.println("开始反转当前数组的顺序");
        if(show_details){
            System.out.println("反转开始前的数组：");
            print_array(this.array_length,this.current_array);
        }
        for(int i=0;i<this.array_length/2;++i){
            int temp=this.current_array[i];
            this.current_array[i]=this.current_array[this.array_length-1-i];
            this.current_array[this.array_length-1-i]=temp;
        }
        System.out.println("反转完成\n");
    }

    private static boolean is_sorted(int array_length,int[] array){
        boolean sorted=true;
        for(int i=0;i<array_length-1;++i){
            if(array[i]>array[i+1]){
                sorted=false;
                break;
            }
        }
        return sorted;
    }

    private static void print_array(int array_length,int[] array){
        int number_of_filled_lines=array_length/10;
        int number_of_elements_in_unfilled_line=array_length%10;
        System.out.print("(");
        for(int i=0;i<number_of_filled_lines;++i){
            System.out.print("\t");
            for(int j=0;j<10;++j){
                System.out.print(array[i*10+j]);
                if(!(i==number_of_filled_lines-1&&j==9&&number_of_elements_in_unfilled_line==0)){
                    System.out.print(",");
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        int next_unprinted_element_index=number_of_filled_lines*10;
        if(next_unprinted_element_index<array_length){
            System.out.print("\t");
            while(next_unprinted_element_index<array_length){
                System.out.print(array[next_unprinted_element_index++]);  //注意数组下标从0开始
                if(!(next_unprinted_element_index==array_length)){
                    System.out.print(",");
                }
                System.out.print("\t");
            }
        }
        System.out.print(")\n\n");
    }
}
