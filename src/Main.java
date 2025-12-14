public class Main {
    public static void main(String[] args) {
        // [설계도] [변수이름] = [객체 생성. 실제 객체를 메모리에 만들자.] [생성자];
        // !!! 다형성 !!!
        // = [클래스명] [변수명] = 대입연산자new [클래스명]이었는데, Champion에서 상속 받으니까 가렌과 에쉬 자리에 챔피언이 들어가도 된다.
        Champion garen3 = new Garen("다형성가렌", 1, 100, 50, 30);
        Champion ashe2 = new Garen("다형성에쉬", 1, 80, 60, 10);

        // 공격
        // 즉 [때릴사람].basicAttackTo[때릴사람]([맞는사람]); 이다.
        garen3.basicAttack(ashe2);  // 80 - (50 - 10) = 40
        ashe2.basicAttack(garen3);  // 100 - (60 - 30) = 70

        // 체력 정리
        System.out.println(garen3.getName() + " 체력 : " + garen3.getHp() + " \n"
                + ashe2.getName() + " 체력 : " + ashe2.getHp());
    }
}
