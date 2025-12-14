// 가렌과 에쉬에서 중복되는 필드변수값 모두 모으기
// 모으고나서 public class [가렌/에쉬] 이것만 뒤에 extends Champion 붙이자.
public abstract class Champion {
    private String name;        // 이름
    private int level;          // 레밸
    private int hp;             // 체력
    private int attackDamage;   // 공격력
    private int defence;        // 방어력

    // 생성자는 이름만 다름.
    public Champion(String name, int level, int hp, int attackDamage, int defence) {
        this.name = name;                   // 이름
        this.level = level;                 // 레밸
        this.hp = hp;                       // 체력
        this.attackDamage = attackDamage;   // 공격력
        this.defence = defence;             // 방어력
    }

    // 피해량
    public void takeDamage(int damage){
        // 내 체력 - (내 방어력 - 적의 공격력) : 내 체력 - 실제 데미지
        int actualDamage = damage - this.defence;   // this.는 private에 숨겨진 이 클래스의 defense(따로 defense 설정해도 그거랑 이거랑 다름)
        if( actualDamage < 0 ) actualDamage = 0;    // if(A) B = 0; -> A이면 B=0이다. : 방어력이 공격력보다 높으면 데미지는 0

        this.hp -= actualDamage; // 내 체력에서 데미지 뺌(hp = hp - actualDamage)

        System.out.println("[ " + this.name + " ]" + "이(가) " + actualDamage + " 피해를 받았습니다!");
        System.out.println("현재 체력: " + this.hp);
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

    // 스킬
    // 내부 로직은 알아서하되, useQ는 모든 챔피언이 사용하니까
    // 추상 클래스로 묶어서 어느 챔피언(캐릭터)이든 useQ/W/E/R만 상속받아서 스킬을 사용할 수 있도록 만들자.
    public abstract void useQ(Champion target);
    public abstract void useW();
    public abstract void useE();
    public abstract void useR();

    // 다형성을 사용하면 타격에 대해서도 묶을 수 있다.
    // 상속으로 분리한 이유 : 중복되는 부분을 일관화
    // 가렌 = 챔피언, 에쉬 = 챔피언
    // 따라서 가렌이 에쉬를 공격한다 = 챔피언이 챔피언을 공격한다.
    public void basicAttack(Champion target){
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "을(를) 기본 공격!");
        target.takeDamage(this.attackDamage);
    }
}
