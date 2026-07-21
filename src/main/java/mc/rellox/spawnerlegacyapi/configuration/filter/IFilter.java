package mc.rellox.spawnerlegacyapi.configuration.filter;

public interface IFilter {

    String key();

    int priority();

    boolean matches(IFilterContext context);

}
