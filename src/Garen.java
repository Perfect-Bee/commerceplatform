public class Garen extends Champion implements MeleeChampion{
// Garen이 Champion의 것을 상속받음

    // Garen를 위한 생성자 재설정
    public Garen(String name, int level, int hp, int attackDamage, int defence) {
        // 부모(Champion)의 생성자를 가져온다.
        super(name, level, hp, attackDamage, defence);
    }

    // 추상화에서 상속 : 오버라이드
    // 스킬
    @Override // @은 문법임. 정의.
    public void useQ(Champion target){
        // 가렌만의 Q 스킬
        System.out.println(getName() + "의 Q스킬!");
        target.takeDamage(getAttackDamage() + 30); // Q스킬은 가렌의 기본 공격력 + 30
    }
    public void useW(){}
    public void useE(){}
    public void useR(){}



    // implements MeleeChampion 추가했으니 오버라이드 체크
    @Override
    public void dash(Champion target){

    }
}
