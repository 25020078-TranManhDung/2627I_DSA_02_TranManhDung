//Lỗi: leader[p] bị thay đổi trong vòng lặp khi i = p
//-> các phần tử sau p có cùng nhóm sẽ bị bỏ sót

public class Bai1 {
    static int[] leader;

    //Lỗi: So sánh với leader[p] (bị thay đổi trong vòng lặp)
    static void unionBug(int p, int q) {
        for (int i = 0; i < leader.length; i++)
            if (leader[i] == leader[p])
                leader[i] = leader[q];
    }

    //Đúng: đóng băng pid trước vòng lặp
    static void unionFix(int p, int q) {
        int pid = leader[p];    //đóng băng nhãn cũ
        int qid = leader[q];
        for (int i = 0; i < leader.length; i++)
            if (leader[i] == pid) leader[i] = qid;
    }

    public static void main(String[] args) {
        //Testcase: n = 3; union(1,2) rồi union(1,0)
        //Mong muốn: 1 và 2 cùng nhóm với 0 -> find(1) == find(2)
        //Thực tế (lỗi): find(1) = 0, find(2) = 2 -> Sai

        leader = new int[]{0,1,2};
        unionBug(1,2);  //leader = [0,2,2]
        unionBug(1,0); //mong muốn [0,0,0], thực tế [0,0,2]
        System.out.println("Lỗi: find(1) = " + leader[1] + " find(2) = " + leader[2]);    //0 != 2

        leader = new int[]{0, 1, 2};
        unionFix(1, 2);
        unionFix(1, 0);
        System.out.println("Đúng: find(1) = " + leader[1] + " find(2) = " + leader[2]);     //0 == 0
    }
}
