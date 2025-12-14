
public class Main {
    public static void main(String[] args) {
        // [설계도] [변수이름] = [객체 생성. 실제 객체를 메모리에 만들자.] [생성자];
        // = [Garen] [garen] = [new] [Garen()];
        Garen garen = new Garen("garen1");
        Ashe ashe = new Ashe("ashe");

        // 이름 변경
        garen.changeName("가붕이");
        ashe.changeName("에붕이");

        // 가렌이 에쉬를 공격함 : basicAttackToAshe(Ashe target)
        garen.basicAttack(ashe);
        // 에쉬가 가렌을 공격함 basicAttackToGaren(Garen target)
        ashe.basicAttack(garen);
        ashe.useR(garen);
        ashe.useR(garen);
        ashe.useR(garen);

        // 가렌이 에쉬를 R 스킬 공격 : skillRAttackToAshe(Ashe target)
        garen.useR(ashe);


        // 체력 정리
        System.out.println(garen.getName() + " 체력 : " + garen.getHp() + " \n"
                 + ashe.getName() + " 체력 : " + ashe.getHp());

        // 가붕이 레밸업
        System.out.println("\n" + garen.getName() + "이(가) 레밸업 하였습니다!");
        garen.levelUp(garen);
        System.out.println("\n" + garen.getName() + "이(가) 레밸업 하였습니다!");
        garen.levelUp(garen);
        System.out.println("\n" + garen.getName() + "이(가) 레밸업 하였습니다!");
        garen.levelUp(garen);
        
        // 에붕이 레밸업
        System.out.println("\n" + ashe.getName() + "이(가) 레밸업 하였습니다!");
        ashe.levelUp(ashe);
    }
}
