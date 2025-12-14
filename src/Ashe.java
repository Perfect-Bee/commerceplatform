public class Ashe extends Champion implements RangeChampion {
// Ashe가 Champion의 것을 상속받음

    // Ashe를 위한 생성자 재설정
    public Ashe(String name, int level, int hp, int attackDamage, int defence) {
        // 부모(Champion)의 생성자를 가져온다.
        super(name, level, hp, attackDamage, defence);
    }

    // 스킬
    @Override // @은 문법임. 정의.
    public void useQ(Champion target){
        // 에쉬만의 Q 스킬
        System.out.println(getName() + "의 Q스킬!");
        target.takeDamage(getAttackDamage() * 2); // 공격력의 200% 
        // 주의. 이거 int라서 실수 안 됨
    }
    public void useW(){}
    public void useE(){}
    public void useR(){}


    // implements RangeChampion 추가했으니 오버라이드 체크
    @Override
    public void kite(){

    }

}
