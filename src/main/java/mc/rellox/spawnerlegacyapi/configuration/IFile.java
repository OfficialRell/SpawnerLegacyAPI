package mc.rellox.spawnerlegacyapi.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

import java.util.List;

public interface IFile extends IMemory, IFileValues {

    /**
     * Creates or initializes this file.
     */

    void create();

    /**
     * @return The configuration file
     */

    FileConfiguration file();

    /**
     * @return File name
     */

    String name();

    /**
     * @return {@code true} if this file was just created
     */

    boolean newly();

    /**
     * Saves all changes to the file.
     */

    void save();

    /**
     * Sets an object to the path and saves this file.
     *
     * @param path   path
     * @param object object to set
     */

    default void set(String path, Object object) {
        file().set(path, object);
        save();
    }

    /**
     * Removes specified path and saves this file.
     *
     * @param path path to remove
     */

    default void clear(String path) {
        file().set(path, null);
        save();
    }

    /**
     * Clears file memory.<br>
     * After using this method most other methods will throw {@link NullPointerException}.
     */

    void free();

    /**
     * Sets a header to this file.
     *
     * @param header header separated by '\n'
     */

    default void header(String header) {
        header(header.split("\\n"));
    }

    /**
     * Sets a header to this file.
     *
     * @param header file header
     */

    default void header(String... header) {
        FileConfigurationOptions options = file().options();
        options.setHeader(List.of(header));
        options.parseComments(true);
    }

    /**
     * @return New commenter for this file
     */

    @Deprecated(since = "3.0.0", forRemoval = true)
    default Commenter commenter() {
        return new Commenter(this);
    }

    @Deprecated(since = "3.0.0", forRemoval = true)
    record Commenter(IFile file) {

        /**
         * Adds comments to this path.
         *
         * @param path     path
         * @param comments comments
         */

        @Deprecated(since = "3.0.0", forRemoval = true)
        public void comment(String path, String... comments) {
            comment(path, List.of(comments));
        }

        /**
         * Adds comments to this path.
         *
         * @param path path
         * @param list comments
         */

        @Deprecated(since = "3.0.0", forRemoval = true)
        public void comment(String path, List<String> list) {
            file.file().setComments(path, list);
        }

    }

}
