package mc.rellox.spawnerlegacyapi.metadata.entity.trait.trigger;

public interface ITrigger {

    /**
     * @param context trigger context
     * @return Whether the trigger should be executed
     */

    boolean test(ITriggerContext context);

    ITrigger ALWAYS = context -> true;
    ITrigger SUCCESS = context -> context.result().success();
    ITrigger FAIL = context -> !context.result().success();
    ITrigger ATTEMPTED = context -> context.result().attempted();
    ITrigger ROLLED = context -> context.result().rolled();
    ITrigger LIMITED = context -> context.result().limited();

    static ITrigger index(int index) {
        return context -> context.index() == index;
    }

    static ITrigger after(int index) {
        return context -> context.index() > index;
    }

    static ITrigger before(int index) {
        return context -> context.index() < index;
    }

    static ITrigger every(int n) {
        if(n <= 1) return ALWAYS;
        return context -> context.index() % n == 0;
    }

}
