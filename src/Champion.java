import java.util.ArrayList;
import java.util.Random;

// 가렌과 에쉬에서 중복되는 필드변수값 모두 모으기
// 모으고나서 public class [가렌/에쉬] 이것만 뒤에 extends Champion 붙이자.
public abstract class Champion {
    private String name;        // 이름
    private int level = 1;          // 레밸
    private int hp;             // 체력
    private int attackDamage;   // 공격력
    private int defence;        // 방어력

    // 부활용
    // 체력 저장
    private int maxhp;

    // 생성자는 이름만 다름.
    public Champion(String name, int hp, int attackDamage, int defence) {
        this.name = name;                   // 이름
        // 체력, 공격력, 방어력은 고정 : 각 챔피언에 연결
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
        // 부활을 위한 최대 체력
        this.maxhp = hp;
    }
    // 체력, 이름 설정(Getter)도 같음
    // 체력 메소드
    public int getHp(){return this.hp;}
    // 이름 메소드
    public String getName(){return this.name;}
    // setter
    // 이름 변경 메소드
    public void changeName(String name){
        // 현재 설정된 이름(private 씌운)에 name 덮어쓰기
        this.name = name;
        new Log("변경된 이름은 : " + this.name);
    }
    public void setHp(int hp){this.hp = hp;}

    // 공격력 메소드
    public int getAttackDamage(){return this.attackDamage;}
    // 피해량
    // + 치명타 적용
    private Random random = new Random();

    public void takeDamage(int damage){
        int actualDamage = damage - this.defence;

        // 실제 데미지(적 공격력 - 내 방어력)
        // 치명타 판정 : 20%(0.2) -> 2배
        if (random.nextDouble() < GameConstants.CRITICAL_CHANCE) {
            actualDamage *= 2;
            new Log("치명타 피해량 : " + actualDamage);
        } else {
            new Log("피해량 : " + actualDamage);
        }
        // 내 체력 - (내 방어력 - 적의 공격력) : 내 체력 - 실제 데미지
        if( actualDamage < 0 ) actualDamage = 0;
        this.hp -= actualDamage;


        if (this.hp <= 0) {
            new Log( this.name + "이(가) 사망하였습니다!");
            hp = 0; // 초기화
            resurrect();
            return;
        }
        new Log(this.name + "의 현재 체력: " + this.hp + "\n");

        // 기본 공격/스킬 사용시
        // 즉 피해 받음 : 카운트 +1
        GameConstants.BATTLE_COUNT++;
    }
    
    // 공격
    public void basicAttack(Champion target){
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "을(를) 기본 공격!");
        target.takeDamage(this.attackDamage);
    }

    // 레밸업!
    public void levelUp(Champion target) {
        if (this.level >= GameConstants.MAX_LEVEL) {
            new Log("레밸 상한에 도달하였습니다");
            return;
        }
        this.level++;              // 레밸
        this.hp += 50;             // 체력
        this.attackDamage += 10;   // 공격력
        this.defence += 5;         // 방어력
        new Log("level : " + this.level + "\n" +
                "hp : " + this.hp + "\n" + "attackDamage : " + this.attackDamage + "\n" + "defence : " + this.defence );
    }
    // 부활 로직
    public final void resurrect() {
        // 혹시 모르니까 살아있는 경우 반환
        if (this.hp > 0) {return;}
        // 고정 규칙: 최대 체력의 20% (최소 1)
        int reviveHp = (int)(this.maxhp * 0.2);
        if (reviveHp < 1) reviveHp = 1;

        this.hp = reviveHp;

        new Log(this.name + "이(가) 부활했습니다! (체력: " + this.hp + ")");
    }
    // 전투 로그 : 리스트에 받은 메시지 넣어서 출력
    public static class Log {
        private static ArrayList<String> logs = new ArrayList<>();
        private final String message;
        // final 정의된 변수를 생성자에서 초기화시킴(자동화 완성됨...)
        public Log(String message) {
            this.message = message;
            System.out.println(message);
        }
        // 여기까지 입력받은 메시지에 대한 로그
        // 전투 로그를 static 중첩 로그 : System.out.pringln -> new Log
    }

    // 스킬
    // 내부 로직은 알아서하되, useQ는 모든 챔피언이 사용하니까
    // 추상 클래스로 묶어서 어느 챔피언(캐릭터)이든 useQ/W/E/R만 상속받아서 스킬을 사용할 수 있도록 만들자.
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);
}
