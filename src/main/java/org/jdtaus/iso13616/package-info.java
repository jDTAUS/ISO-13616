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
// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 *
 * International Bank Account Number.
 * <p>The IBAN structure is defined in ISO 13616-1 and consists of a two-letter ISO 3166-1 country code, followed by two
 * check digits and up to thirty alphanumeric characters for a BBAN (Basic Bank Account Number) which has a fixed length
 * per country and, included within it, a bank identifier with a fixed position and a fixed length per country. The
 * check digits are calculated based on the scheme defined in ISO/IEC 7064 (MOD97-10). The Society for Worldwide
 * Interbank Financial Telecommunication SCRL, SWIFT, has been designated by the ISO Technical Management Board to act
 * as the Registration Authority for ISO 13616. Nationally-agreed, ISO 13616-compliant IBAN formats are submitted to the
 * registration authority exclusively by the National Standards Body or the National Central Bank of the country. For
 * further information see the <a href="../../../doc-files/IBAN-Registry_Release-46_November-2013.pdf">IBAN REGISTRY</a>.
 * An updated version of the document may be found at <a href="http://www.swift.com">SWIFT</a>.</p>
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN</dd>
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
package org.jdtaus.iso13616;
