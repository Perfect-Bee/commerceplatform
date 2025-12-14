import java.util.Random;

// 가렌과 에쉬에서 중복되는 필드변수값 모두 모으기
// 모으고나서 public class [가렌/에쉬] 이것만 뒤에 extends Champion 붙이자.
public abstract class Champion {
    private String name;        // 이름
    private int level = 1;          // 레밸
    private int hp;             // 체력
    private int attackDamage;   // 공격력
    private int defence;        // 방어력

    // 전투 카운트(챔피언 공유)
    private static int battleCount = 0;

    // 생성자는 이름만 다름.
    public Champion(String name, int hp, int attackDamage, int defence) {
        this.name = name;                   // 이름
        // 체력, 공격력, 방어력은 고정 : 각 챔피언에 연결
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
    }

    // 피해량
    // + 치명타 적용
    private Random random = new Random();

    public void takeDamage(int damage){
        // 치명타 적용 데미지 : ranAD
        int ranAD = attackDamage * 2;
        int actualDamage;

        // 치명타 판정 : 20%(0.2)
        if (random.nextDouble() < GameConstants.CRITICAL_CHANCE) {
            actualDamage = damage - ranAD;
            System.out.println("치명타 발생!");
        } else {
            actualDamage = damage - this.defence;
        }
        // 내 체력 - (내 방어력 - 적의 공격력) : 내 체력 - 실제 데미지
        if( actualDamage < 0 ) actualDamage = 0;
        this.hp -= actualDamage;
        if (this.hp <= 0) {
            System.out.println( this.name + "이(가) 사망하였습니다!");
            hp = 0; // 초기화
        }
        System.out.println(this.name + "의 현재 체력: " + this.hp + "\n");
        // 기본 공격/스킬 사용시
        // 즉 피해 받음 : 카운트 +1
        battleCount ++;
    }

    // 체력, 이름 설정(Getter)도 같음
    // 체력 메소드
    public int getHp(){
        return this.hp;
    }

    // 이름 메소드
    public String getName(){
        return this.name;
    }
    // 이름 변경 메소드
    public void changeName(String name){
        // 현재 설정된 이름(private 씌운)에 name 덮어쓰기
        this.name = name;
        System.out.println("변경된 이름은 : " + this.name);
    }
    // 공격력 메소드
    public int getAttackDamage(){
        return this.attackDamage;
    }

    // 다형성을 사용하면 타격에 대해서도 묶을 수 있다.
    // 상속으로 분리한 이유 : 중복되는 부분을 일관화
    // 가렌 = 챔피언, 에쉬 = 챔피언
    // 따라서 가렌이 에쉬를 공격한다 = 챔피언이 챔피언을 공격한다.
    public void basicAttack(Champion target){
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "을(를) 기본 공격!");
        target.takeDamage(this.attackDamage);
    }

    // 레밸업!
    public void levelUp(Champion target) {
        this.level++;              // 레밸
        this.hp += 50;             // 체력
        this.attackDamage += 10;   // 공격력
        this.defence += 5;         // 방어력
        System.out.println("level : " + this.level + "\n" +
                "hp : " + this.hp + "\n" + "attackDamage : " + this.attackDamage + "\n" + "defence : " + this.defence );
    }

    // 고정된 부활 추가
    final void resurrect(){}

    // 스킬
    // 내부 로직은 알아서하되, useQ는 모든 챔피언이 사용하니까
    // 추상 클래스로 묶어서 어느 챔피언(캐릭터)이든 useQ/W/E/R만 상속받아서 스킬을 사용할 수 있도록 만들자.
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);
}
