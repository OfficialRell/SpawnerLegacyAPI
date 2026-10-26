package mc.rellox.spawnerlegacyapi.configuration.filter;

public interface IFilter {

    /**
     * @return Filter key
     */

    String key();

    /**
     * @return Filter priority
     */

    int priority();

    /**
     * @param context filter context
     * @return Whether the filter matches the given context
     */

    boolean matches(IFilterContext context);

}
