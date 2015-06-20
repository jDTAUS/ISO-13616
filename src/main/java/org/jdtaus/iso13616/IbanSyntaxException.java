// SECTION-START[License Header]
// <editor-fold defaultstate="collapsed" desc=" Generated License ">
/*
 *   jDTAUS ⁑ ISO-13616
 *   Copyright (C) Christian Schulte, 2013-222
 *
 *   Permission to use, copy, modify, and/or distribute this software for any
 *   purpose with or without fee is hereby granted, provided that the above
 *   copyright notice and this permission notice appear in all copies.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 *   WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 *   MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 *   ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 *   WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 *   ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 *   OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 *   $JDTAUS$
 *
 */
// </editor-fold>
// SECTION-END
package org.jdtaus.iso13616;

import java.util.Locale;

// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 * Gets thrown whenever parsing text to produce an international bank account number fails.
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN Syntax Exception</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN Syntax Exception</dd>
 *   <dt><b>Abstract:</b></dt><dd>No</dd>
 *   <dt><b>Final:</b></dt><dd>Yes</dd>
 *   <dt><b>Stateless:</b></dt><dd>No</dd>
 * </dl>
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version 1.1
 */
// </editor-fold>
// SECTION-END
// SECTION-START[Annotations]
// <editor-fold defaultstate="collapsed" desc=" Generated Annotations ">
@javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.9", comments = "See http://www.jomc.org/jomc/1.9/jomc-tools-1.9" )
// </editor-fold>
// SECTION-END
public class IbanSyntaxException extends Exception
{
    // SECTION-START[IbanSyntaxException]

    /** Serial version UID for backwards compatibility with 2007.45.x classes. */
    private static final long serialVersionUID = -475265309170567430L;

    /**
     * The malformed text.
     * @serial
     */
    private String malformedText;

    /**
     * The position at which parsing failed.
     * @serial
     */
    private int errorIndex;

    /**
     * Creates a new {@code IbanSyntaxException} instance taking malformed text and a position at which parsing failed.
     *
     * @param malformedText The malformed text.
     * @param errorIndex The position at which parsing failed.
     */
    public IbanSyntaxException( final String malformedText, final int errorIndex )
    {
        super();
        this.malformedText = malformedText;
        this.errorIndex = errorIndex;
    }

    /**
     * Gets a message describing the exception.
     *
     * @return A message describing the exception.
     */
    @Override
    public String getMessage()
    {
        return getIbanSyntaxExceptionMessage( Locale.getDefault(), this.getMalformedText(), this.getErrorIndex() );
    }

    /**
     * Gets a localized message describing the exception for a given locale.
     *
     * @param locale The locale of the localized message to get.
     *
     * @return A localized message describing the exception.
     *
     * @throws NullPointerException if {@code locale} is {@code null}.
     */
    public String getLocalizedMessage( final Locale locale )
    {
        if ( locale == null )
        {
            throw new NullPointerException( "locale" );
        }

        return getIbanSyntaxExceptionMessage( locale, this.getMalformedText(), this.getErrorIndex() );
    }

    /**
     * Gets the malformed text causing the exception.
     *
     * @return The malformed text causing the exception.
     */
    public String getMalformedText()
    {
        return this.malformedText;
    }

    /**
     * Gets the position at which parsing failed.
     *
     * @return The position at which parsing failed.
     */
    public int getErrorIndex()
    {
        return this.errorIndex;
    }

    // SECTION-END
    // SECTION-START[Dependencies]
    // SECTION-END
    // SECTION-START[Properties]
    // SECTION-END
    // SECTION-START[Messages]
    // <editor-fold defaultstate="collapsed" desc=" Generated Messages ">
    /**
     * Gets the text of the {@code <IBAN Syntax Exception Message>} message.
     * <p><dl>
     *   <dt><b>Languages:</b></dt>
     *     <dd>English (default)</dd>
     *     <dd>Deutsch</dd>
     *   <dt><b>Final:</b></dt><dd>No</dd>
     * </dl></p>
     * @param locale The locale of the message to return.
     * @param malformedText Format argument.
     * @param errorIndex Format argument.
     * @return The text of the {@code <IBAN Syntax Exception Message>} message for {@code locale}.
     */
    @SuppressWarnings({"unchecked", "unused", "PMD.UnnecessaryFullyQualifiedName"})
    @javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.9", comments = "See http://www.jomc.org/jomc/1.9/jomc-tools-1.9" )
    private static String getIbanSyntaxExceptionMessage( final java.util.Locale locale, final java.lang.String malformedText, final java.lang.Number errorIndex )
    {
        java.io.BufferedReader reader = null;

        try
        {
            final String message = java.text.MessageFormat.format( java.util.ResourceBundle.getBundle( "org.jdtaus.iso13616.IbanSyntaxException", locale ).getString( "IBAN Syntax Exception Message" ), malformedText, errorIndex, (Object) null );
            final java.lang.StringBuilder builder = new java.lang.StringBuilder( message.length() );
            reader = new java.io.BufferedReader( new java.io.StringReader( message ) );
            final String lineSeparator = System.getProperty( "line.separator", "\n" );

            String line;
            while ( ( line = reader.readLine() ) != null )
            {
                builder.append( lineSeparator ).append( line );
            }

            reader.close();
            reader = null;
            return builder.length() > 0 ? builder.substring( lineSeparator.length() ) : "";
        }
        catch( final java.io.IOException e )
        {
            throw new java.lang.AssertionError( e );
        }
        finally
        {
            try
            {
                if( reader != null )
                {
                    reader.close();
                }
            }
            catch( final java.io.IOException e )
            {
                throw new java.lang.AssertionError( e );
            }
        }
    }
    // </editor-fold>
    // SECTION-END
}
