public class Garen extends Champion implements MeleeChampion {
// Garen이 Champion의 것을 상속받음

    // Garen를 위한 생성자 재설정
    public Garen(String name) {
        // 부모(Champion)의 생성자를 가져온다.
        // GameConstants에서 고정값 적용
        super(name, GameConstants.GAREN_HP, GameConstants.GAREN_AD, GameConstants.GAREN_DF);
    }

    // 추상화에서 상속 : 오버라이드
    // 스킬
    @Override
    public void useQ(Champion target){
        // 가렌만의 Q 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 Q스킬!");
        target.takeDamage(getAttackDamage() + 30); // Q스킬은 가렌의 기본 공격력 + 30
    }
    public void useW(Champion target){
        // 가렌만의 W 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 W스킬!");
        target.takeDamage(getAttackDamage() + 60); // Q스킬은 가렌의 기본 공격력 + 30
    }
    public void useE(Champion target){
        // 가렌만의 E 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 E스킬!");
        target.takeDamage(getAttackDamage() + 90); // Q스킬은 가렌의 기본 공격력 + 30
    }
    public void useR(Champion target){
        // 가렌만의 R 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 R스킬!");
        target.takeDamage(getAttackDamage() + 120); // Q스킬은 가렌의 기본 공격력 + 30
    }


    // implements MeleeChampion 추가했으니 오버라이드 체크
    @Override
    public void dash(Champion target){

    }
}
