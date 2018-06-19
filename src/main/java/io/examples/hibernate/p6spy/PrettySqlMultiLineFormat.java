package io.examples.hibernate.p6spy;

import com.p6spy.engine.spy.appender.CustomLineFormat;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;

/**
 * https://github.com/gbatalski/p6spy-pretty-sql-format
 */
public class PrettySqlMultiLineFormat extends CustomLineFormat {
    private static final Formatter formatter;

    static {
        formatter = new BasicFormatterImpl();
    }

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql) {
        return super.formatMessage(connectionId, now, elapsed, category, formatter.format(prepared), formatter.format(sql));
    }
}
